import nltk
from nltk import *
from nltk.corpus import wordnet
from nltk import PorterStemmer
#from nltk.sentiment import SentimentIntensityAnalyzer
# TODO: Vader Shit
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer

import config


class sentiment_analysis():

    def test_vader(self):
        analyzer = SentimentIntensityAnalyzer()
        for sentence in sentences:
            vs = analyzer.polarity_scores(sentence)
            print("{:-<65} {}".format(sentence, str(vs)))

    def getSubmissions(self, assignmentID):
        assignment = config.COURSE.get_assignment(assignmentID)
        users = config.COURSE.get_users(enrollment_type=['student'])
        for user in users:
            peer_reviews = assignment.get_submission(user).get_submission_peer_reviews(include='submission_comments')
            num_reviews = 0
            compound_sum = 0
            for peer_review in peer_reviews:
                if peer_review.workflow_state == 'completed':
                    comments = peer_review.submission_comments
                    for comment in comments:
                        compound_sum = compound_sum + self.analyze(comment['comment'])
                        print(compound_sum)
                        num_reviews = num_reviews + 1
                else:
                    print('Peer Review not completed')
            if (num_reviews != 0):
                average_compound = compound_sum / num_reviews
                grade_1 = self.grade(average_compound)
            else:
                grade_1 = 0
            x = assignment.get_submission(user).edit(submission = {
                'posted_grade':grade_1})


    def analyze(self, text):
        sia = SentimentIntensityAnalyzer()
        y = text.split('.')
        z = 0
        w = 0
        for sentence in y:
            z = z + 1
            x = sia.polarity_scores(sentence)
            w = w + x['compound']

        result = w/z
        if (result<-0.05):
            print("Someone got a bad review :(")
        return result

    def grade(self, average_compound):
        if average_compound > 0.05:
            return 10
        elif average_compound < -0.05:
            return 1
        else:
            return 4

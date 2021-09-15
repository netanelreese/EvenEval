import nltk
from nltk import *
from nltk.corpus import wordnet
from nltk import PorterStemmer
from nltk.sentiment import SentimentIntensityAnalyzer
# TODO: Vader Shit
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer

import config


class sentiment_analysis():

    def test_vader(self):
        sentences = ["Nate is smart, handsome, and funny!",
                     # punctuation emphasis handled correctly (sentiment intensity adjusted)
                     "VADER is VERY SMART, handsome, and FUNNY.",  # emphasis for ALLCAPS handled
                     "VADER is VERY SMART, handsome, and FUNNY!!!",
                     # combination of signals - VADER appropriately adjusts intensity
                     "VADER is VERY SMART, uber handsome, and FRIGGIN FUNNY!!!",
                     # booster words & punctuation make this close to ceiling for score
                     "VADER is not smart, handsome, nor funny.",  # negation sentence example
                     "The book was good.",  # positive sentence
                     "At least it isn't a horrible book.",  # negated negative sentence with contraction
                     "The book was only kind of good.",
                     # qualified positive sentence is handled correctly (intensity adjusted)
                     "The plot was good, but the characters are uncompelling and the dialog is not great.",
                     # mixed negation sentence
                     "Today SUX!",  # negative slang with capitalization emphasis
                     "Today only kinda sux! But I'll get by, lol",
                     # mixed sentiment example with slang and constrastive conjunction "but"
                     "Make sure you :) or :D today!",  # emoticons handled
                     "Catch utf-8 emoji such as such as 💘 and 💋 and 😁",  # emojis handled
                     "Not bad at all"  # Capitalized negation
                     ]

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
                    num_reviews = num_reviews + 1
                    compound_sum = compound_sum + self.analyze(peer_review.submission_comments[0]['comment'])
                else:
                    print('Peer Review not completed')
            if (num_reviews != 0):
                average_compound = compound_sum / num_reviews
                grade_1 = self.grade(average_compound)
            else:
                grade_1 = 0
            x = assignment.get_submission(user).edit(submission = {
                'posted_grade':grade_1})


    def train(self):
        print()

    def analyze(self, text):
        sia = SentimentIntensityAnalyzer()
        x = sia.polarity_scores(text)
        if (x['compound']<-.05):
            "Someone got a bad review :("
        return x['compound']

    def grade(self, average_compound):
        if average_compound > 0.05:
            return 10
        elif average_compound < 0.05:
            return 1
        else:
            return 4
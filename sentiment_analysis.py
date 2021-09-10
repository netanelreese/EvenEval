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
        sentences = ["VADER is smart, handsome, and funny.",  # positive sentence example
                     "VADER is smart, handsome, and funny!",
                     # punctuation emphasis handled correctly (sentiment intensity adjusted)
                     "VADER is very smart, handsome, and funny.",
                     # booster words handled correctly (sentiment intensity adjusted)
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
            peer_reviews = assignment.get_submission(user).get_submission_peer_reviews()
            num_reviews = 0
            for peer_review in peer_reviews:
                num_reviews = num_reviews+1
                



    def train(self):
        print()

    def analyze(self, text):
        sia = SentimentIntensityAnalyzer()
        sia.polarity_scores(text)

    def read_text(self):
        print()

    def test_features(self, word):
        stemmer = PorterStemmer()
        stemmer.stem(word)
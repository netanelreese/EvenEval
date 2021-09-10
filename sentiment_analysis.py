import nltk
from nltk import *
from nltk.corpus import wordnet
from nltk import PorterStemmer
from nltk.sentiment import SentimentIntensityAnalyzer

import config


class sentiment_analysis():

    def getSubmissions(self, assignmentID):
        assignment = config.COURSE.get_assignment(assignmentID)
        users = config.COURSE.get_users()
        for user in users:
            peer_reviews = assignment.get_submission(user.id).get_submission_peer_reviews()

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
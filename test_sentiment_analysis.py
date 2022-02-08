import unittest
import sentiment_analysis


class TestSentiment(unittest.TestCase):

    def test_grade(self):
        s = sentiment_analysis.sentiment_analysis()
        self.assertEqual(s.grade(0.5), 10)
        self.assertEqual(s.grade(-.5), 1)
        self.assertEqual(s.grade(0), 4)
        self.assertEqual(s.grade(.05), 4)
        self.assertEqual(s.grade(-.05), 4)

    def test_analyze(self):
        s = sentiment_analysis.sentiment_analysis()
        self.assertGreater(s.analyze('Great'), .05)
        self.assertGreater(s.analyze('Nick'), -.05)
        self.assertLess(s.analyze('Nick'), .05)
        self.assertLess(s.analyze('Bad'), -.05)

    def test_getSubmissions(self):
        s = sentiment_analysis.sentiment_analysis()
        


if __name__ == '__main__':
    unittest.main()

import unittest
import sentiment_analysis
import config


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
        assignmentID = 1690556
        s.getSubmissions(assignmentID)

        assignment = assignment = config.COURSE.get_assignment(assignmentID)
        users = config.COURSE.get_users(enrollment_type=['student'])

        for user in users:
            grade = assignment.get_submission(user).grade
            if user.id == 188153:
                self.assertEqual(grade, '4')
            elif user.id == 223095:
                self.assertEqual(grade, '1')
            else:
                self.assertEqual(grade, '0')



if __name__ == '__main__':
    unittest.main()

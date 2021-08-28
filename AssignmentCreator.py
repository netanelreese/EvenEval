import config
from canvasapi import *

class AssignmentCreator:
    def createQuiz (self, studentName):
        quiz = config.COURSE.create_quiz({'title' : studentName})
        quiz.create_question(question={
            'question_name': 'Gender',
            'question_type': 'multiple_choice_question',
            'question_text': 'Which gender do you identify as?',
            'points_possible': '100.0',
            'answers': [{'answer_text':'Male', 'weight':100.0}
                ,{'answer_text':'Female', 'weight':0.0}
                ,{'answer_text':'Other', 'weight':0.0}
                ,{'answer_text':'Prefer not to say', 'weight':0.0}
                ]
        })
    def generateIndQuizzes(self):
        users = config.COURSE.get_users(enrollment_type=['student'])
        for user in users:
            currName = user.name + ' Evaluation'
            quiz = self.createQuiz(currName)
            self.assignQuiz(quiz, user)

    def assignQuiz(self, quiz, user):
        return 1





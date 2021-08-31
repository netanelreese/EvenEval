import canvasapi.quiz

import config
from canvasapi import *

class AssignmentCreator:

    def createQuiz (self, studentName, groupid):

        quiz = config.COURSE.create_quiz({
            'title' : studentName,
            'assignment_group_id' : 1,
            'for': [188153]
        })
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
        return quiz
    def generateIndQuizzes(self):

        groups = config.COURSE.get_groups()
        for group in groups:
            module = config.COURSE.create_module({'name':group.name})
            users = group.get_users(enrollment_type=['student'])
            for user in users:
                currName = user.name + ' Evaluation'
                quiz = self.createQuiz(currName, group.id)
                module.create_module_item({'title':quiz.title,'type':'Quiz', 'content_id':quiz.id})
                #quiz.edit({'assignment_visibility':self.assignQuiz(quiz, user, group)})

    def assignQuiz(self, quiz: canvasapi.quiz.Quiz, user, group):
        users = group.get_users()
        x = []
        for others in users:
            if (others.id != user.id):
                x.append(user.id)
        return x






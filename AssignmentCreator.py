import canvasapi.quiz

import config
from canvasapi import *

class AssignmentCreator:

    def createQuiz (self, studentName, id):

        assignment = config.COURSE.create_quiz(quiz={
            'title': studentName,
            'quiz_type': 'assignment',
            'only_visible_to_overrides': True,
            'quiz_assignment_overrides': [{
                'student_ids' : [id]
            }]
        })
        config.COURSE.get_assignment(assignment.id).create_override({'student_ids':id})
        assignment.create_question(question = {
                'question_name': 'Gender',
                'question_type': 'multiple_choice_question',
                'question_text': 'Which gender do you identify as?',
                'points_possible': '100.0',
                'answers': [{'answer_text': 'Male', 'weight': 100.0}
                        , {'answer_text': 'Female', 'weight': 0.0}
                        , {'answer_text': 'Other', 'weight': 0.0}
                        , {'answer_text': 'Prefer not to say', 'weight': 0.0}
                ]})
        return assignment
    def generateIndQuizzes(self):

        groups = config.COURSE.get_groups()
        for group in groups:
            module = config.COURSE.create_module({'name':group.name, 'published':True})
            users = group.get_users(enrollment_type=['student'])
            for user in users:
                currName = user.name + ' Evaluation ' + str(self.y)
                self.y = self.y +1
                assignment = self.createQuiz(currName, user.id)
                #quiz = self.createQuiz(currName, group.id)
                module.create_module_item({'title':assignment.title,'type':'Quiz', 'content_id':assignment.id})
                for other in users:
                    if (user.id != other.id):
                        x=1



                #quiz.edit({'assignment_visibility':self.assignQuiz(quiz, user, group)})

    def assignQuiz(self, quiz: canvasapi.quiz.Quiz, user, group):
        users = group.get_users()
        x = []
        for others in users:
            if (others.id != user.id):
                x.append(user.id)
        return x






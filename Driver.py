from canvasapi import *
import config
import Grouper
import Grader
import AssignmentCreator

def main() :

    assignment = AssignmentCreator.AssignmentCreator()
    assignment.generateIndQuizzes()
    quiz = config.COURSE.get_quiz(289596)
    print(quiz)



if __name__ == "__main__":
    main()
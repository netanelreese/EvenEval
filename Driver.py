from canvasapi import *
import config
import Grouper
import Grader
import AssignmentCreator

def main() :

    assignment = AssignmentCreator.AssignmentCreator()
    assignment.createQuiz()


if __name__ == "__main__":
    main()
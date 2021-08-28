from canvasapi import *
import config
import Grouper
import Grader
import AssignmentCreator

def main() :

    assignment = AssignmentCreator.AssignmentCreator()
    assignment.generateIndQuizzes()


if __name__ == "__main__":
    main()
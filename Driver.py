import canvasapi

import auto_peer_review
import config
import Grouper
import Grader
import AssignmentCreator
import sentiment_analysis

def main() :

    x = input('Press A for creating assignment and B for grading peer reviews')

    #TODO: Peer Review Tests
    if (x == 'A'):
        peer_review_number = input('Hello, what number peer review assignment is this?')
        peer_review_name = 'Peer Evaluation ' + str(peer_review_number)

        peer = auto_peer_review.APR()
        peer.create_assn(peer_review_name)

    #TODO: NLTK Tests
    if (x == 'B'):
        assignment_id = input('What is the assignment id?')
        processor = sentiment_analysis.sentiment_analysis()
        processor.getSubmissions(assignment_id)

if __name__ == "__main__":
    main()
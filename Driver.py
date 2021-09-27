import canvasapi

import auto_peer_review
import config
import Grouper
import Grader
import AssignmentCreator
import sentiment_analysis

def main() :


    with open('A.txt', 'r') as file:
        lines = [line.strip() for line in file]

    x = lines[0];

    #TODO: Peer Review Tests
    if (x == 'A'):
        peer_review_number = lines[1]
        peer_review_name = 'Peer Evaluation ' + str(peer_review_number)
        pos_neg = "P"

        peer = auto_peer_review.APR()
        peer.create_assn(peer_review_name, pos_neg)
        print("A success")

    #TODO: NLTK Tests
    if (x == 'B'):
        assignment_id = lines[1]
        processor = sentiment_analysis.sentiment_analysis()
        processor.getSubmissions(assignment_id)
        print("B Success")

if __name__ == "__main__":
    main()
import canvasapi

import auto_peer_review
import config
import Grouper
import Grader
import AssignmentCreator
import sentiment_analysis

def main() :


    #TODO: Peer Review Tests

    #peer_review_number = input('Hello, what number peer review assignment is this?')
    #peer_review_name = 'Peer Evaluation ' + str(peer_review_number)

    #peer = auto_peer_review.APR()
    #peer.create_assn(peer_review_name)

    #TODO: NLTK Tests
    processor = sentiment_analysis.sentiment_analysis()
    print(processor.test_features("Walking"))

    darth_vader = sentiment_analysis.sentiment_analysis()
    darth_vader.test_vader();

if __name__ == "__main__":
    main()
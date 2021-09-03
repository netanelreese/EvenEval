import canvasapi

import auto_peer_review
import config
import Grouper
import Grader
import AssignmentCreator

def main() :

    peer_review_number = input('Hello, what number peer review assignment is this?')
    peer_review_name = 'Peer Evaluation ' + str(peer_review_number)

    peer = auto_peer_review.APR()
    peer.create_assn(peer_review_name)



if __name__ == "__main__":
    main()
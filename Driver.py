import canvasapi

import auto_peer_review
import config
import Grouper
import Grader
import AssignmentCreator

def main() :

    peer = auto_peer_review.APR()
    peer.create_assn()



if __name__ == "__main__":
    main()
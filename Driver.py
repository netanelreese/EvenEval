from canvasapi import *
import config
import Grouper
import Grader

def main() :
    grouper = Grouper.Grouper()
    grouper.create_group(config.GROUP_CATEGORY_ID)
if __name__ == "__main__":
    main()
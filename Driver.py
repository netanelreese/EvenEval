from canvasapi import *
import config
import Grouper
import Grader

def main() :
    grouper = Grouper.Grouper()
    grouper.create_group(config.GROUP_CATEGORY_ID, "Peussy")
    sugmas = config.COURSE.get_groups()
    for sugma in sugmas:
        print(sugma.name)

if __name__ == "__main__":
    main()
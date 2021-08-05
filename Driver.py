from canvasapi import *
import config
import Grouper
import Grader

def main() :
    grouper = Grouper.Grouper()
    grouper.autogroup(2, config.GROUP_CATEGORY_ID, 2)
    groups = config.COURSE.get_groups()
    for group in groups:
        print(group.name)
        users = group.get_users()
        for user in users:
            print(user)


if __name__ == "__main__":
    main()
from canvasapi import *
import config
import Grouper
import Grader

def main() :
    grouper = Grouper.Grouper()
    grouper.create_group(config.GROUP_CATEGORY_ID)
    Violet = config.COURSE.get_groups()[0]
    grouper.add_members(Violet.id, 188153)
    groups = config.COURSE.get_groups()
    for group in groups:
        print(group.name)
        users = group.get_users()
        for user in users:
            print(user)

if __name__ == "__main__":
    main()
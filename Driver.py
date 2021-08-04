from canvasapi import *
import config
import Grouper
import Grader

def main() :
    grouper = Grouper.Grouper()
    grouper.create_group(config.GROUP_CATEGORY_ID)
    groupid = config.COURSE.get_groups()[0]
    violet_user = config.COURSE.get_user(188153)
    print(violet_user)
    grouper.add_members(groupid.id, violet_user)
    groups = config.COURSE.get_groups()
    for group in groups:
        print(group.name)
        users = group.get_users()
        for user in users:
            print(user)

if __name__ == "__main__":
    main()
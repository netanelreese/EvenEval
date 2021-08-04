from canvasapi import *
import config
import Grouper
import Grader

def main() :
    grouper = Grouper.Grouper()
    grouper.create_group(config.GROUP_CATEGORY_ID, "Group 1")
    violet_user = config.COURSE.get_user(188153)
    group1 = config.COURSE.get_groups()[0]
    print(group1.name)
    grouper.add_members(group1.id, violet_user)
    users = group1.get_users()
    for user in users:
        print(user.name)

    grouper.remove_members(group1.id, violet_user.id)

    print(group1.name)

    users = group1.get_users()
    for user in users:
        print(user.name)

    group1.delete()

if __name__ == "__main__":
    main()
from math import floor

from canvasapi.group import GroupCategory

import config
from canvasapi import *
import Grader

class Grouper:
    def autogroup(self, group_num, category_id, class_num): #Auto groups each member in a course
        i = 0
        num_users = self.cal_user_num(class_num, group_num)
        while (i < group_num):
            group_name = "Group " + str(i)
            self.create_group(category_id, group_name)
    def create_group(self, category_id, group_name): #Creates a group within a category id
        course = config.COURSE #retrieves the course from the config
        categories = course.get_group_categories() #gets all of the group categories from the course
        for category in categories: #loops through all of the categories and if one matches the input ID it creates a group inside of it
            id = category.id
            if (id == category_id): #compares the category id's to the input parameter
                group = category.create_group() #creates a group
                group.edit(name=group_name) #should name the group, isnt

    def get_students_from_group_id(self, group_id):
        groups = config.COURSE.get_groups()
        for group in groups:
            if (group.id == group_id):
                return group.get_users()
            else:
                print("Fuck you asshole you gave us the wrong id")
    def add_members(self, group_id, user_id):
        groups = config.COURSE.get_groups()
        for group in groups:
            if (group.id == group_id):
                group.create_membership(user_id)
    def remove_members(self, group_id, user_id):
        groups = config.COURSE.get_groups()
        for group in groups:
            if (group.id == group_id):
                users = group.get_users()
                for user in users:
                    if (user.id == user_id):
                        group.remove_user(user)
    def find_user(self, user_id):
        users = config.COURSE.get_users()
        for user in users:
            if (user.id == user_id):
                return True
        return False
    def cal_user_num(self, class_num, group_num):
        return floor(class_num/group_num)


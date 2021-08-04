from canvasapi.group import GroupCategory

import config
from canvasapi import *
import Grader

class Grouper:
    def autogroup(self):
        print("sugma balls")
    def create_group(self, category_id):
        course = config.COURSE
        categories = course.get_group_categories()
        for category in categories:
            id = category.id
            if (id == category_id):
                group = category.create_group()
                group.edit(group={'name': 'Maddie Quiroga'})
                print(group)
                group.delete() #TODO : DELETE THIS

    def get_students_from_group_id(self, group_id):
        groups = config.COURSE.get_groups()
        for group in groups:
            if (group == group_id):
                return group.get_users()
            else:
                print("Fuck you asshole you gave us the wrong id")
    def add_members(self, group_id, user_id):
        print()
    def remove_members(self, group_id, user_id):
        print()

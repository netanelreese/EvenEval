import config
from canvasapi import *
import Grader

class Grouper:
    def autogroup(self):
    def create_group(self):
        
    def get_students_from_group_id(self, group_id):
        groups = config.COURSE.get_groups()
        for group in groups:
            if (group == group_id):
                return group.get_users()
            else:
                print("Fuck you asshole you gave us the wrong id")
    def add_members(self):
    def remove_members(self):

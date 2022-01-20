import config
from canvasapi import *

def main():
     with open('config.toml', 'r') as file:
          curr = file.readlines()
          while curr.__len__() > 3:
               curr.pop()
          file.close()
     with open('config.toml', 'w') as file:
          file.writelines(curr)
          file.close()
     with open('config.toml', 'a') as file:
          lines = []
          group_cats = config.COURSE.get_group_categories()
          for group_cat in group_cats:
               cat = group_cat.name + " " + str(group_cat.id) + '\n'
               lines.append(cat)
          file.writelines(lines)
          file.close()


if __name__ == "__main__":
     main()
import canvasapi
from canvasapi import *

with open('config.toml', 'r') as file:
    lines = [line.strip() for line in file]


API_KEY = lines[0]
GROUP_CATEGORY_ID = lines[3]
COURSE_ID = lines[2]
API_URL = lines[1]
CANVAS = Canvas(API_URL, API_KEY)
COURSE = CANVAS.get_course(COURSE_ID)

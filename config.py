import canvasapi
from canvasapi import *
API_KEY = "8808~C9JfDkkuDluz4FEs0pQXX8WHQfjIukBVcC9xT3sGBh43GfN76PbJ65ZT59PPCk8T"
GROUP_CATEGORY_ID = 16153
COURSE_ID = 244904
API_URL = "https://canvas.ou.edu/"
CANVAS = Canvas(API_URL, API_KEY)
COURSE = CANVAS.get_course(COURSE_ID)

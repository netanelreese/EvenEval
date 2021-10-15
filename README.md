# EvenEval  [![CodeQL](https://github.com/netanelreese/EvenEval/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/netanelreese/EvenEval/actions/workflows/codeql-analysis.yml)
**CANVAS LMS SOFTWARE PLUGIN**

### Vocabulary Used
- APR: Automatic Peer Review, refers to automatic_peer_review.py and its functions
- SA: Sentiment Analysis: refers to sentiment_analysis.py and its functions
- LMS: Learning Management System: Software used to manage courses in universities, primary schools and other learning environments, Canvas LMS is what was used in this project.


## FEATURES
* Sentiment Analysis
* Auto Grouping Students
* Auto Peer Review Generation and Analysis

## INSTRUCTIONS
### Initial Settings
1. **GENERATE API KEY:**
- To generate an api key you need to navigate to your canvas home page
- After navigating to your home page click on "Account"
- On the side bar that pops up, scroll down to where it says *Approved Integrations*
- Click on the *New Access Token* button
- Enter in **EvenEval** as your purpose and enter in an expiration date if you wish
- Copy the token and paste into the API Key field
2. **URL**
- i.e. in the url bar of this screenshot the url is `https://canvas.ou.edu/courses/244904` the course url for this box would be
`https://canvas.ou.edu`
- Paste this into the URL fied
3. **FIND COURSE ID**
- In canvas, navigate to which class you would like to use with EvenEval through the *courses* button
- Once there, look in your url bar, and at the end of the url, the course id will be displayed
- i.e. in the url bar of this screenshot the url is `https://canvas.ou.edu/courses/244904` the course id would be 244904
- Paste the id into the ID field

### Create Peer Evalution Assignment
- To create an assignment click on `Create an Assignment` and enter in the number of your liking, this will create an assignment by the name of `Peer Review #`

### Grade Peer Evaluation Assignment
- To grade your peer review assignments click `Grade an Assignment`
- Now navigate to the assignment page in your canvas
- Click on the assignment you want to grade
- Once at the page, you will copy the last number present in the url bar (i.e. in `https://canvas.ou.edu/courses/244904/assignments/1690556` 1690556 is the assignment id
- Copy and paste the assignment id into the text box and press OK

### Updating Settings
- Your settings will be saved from your initial settup and displayed in the text field
- To update, change the necessary texfield using previous instructions under **Initial Settup**

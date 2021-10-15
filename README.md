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
1. **GENERATE API KEY:**
- To generate an api key you need to navigate to your canvas home page
- After navigating to your home page click on "Account"
- On the side bar that pops up, scroll down to where it says *Approved Integrations*
- Click on the *New Access Token* button
- Enter in **EvenEval** as your purpose and enter in an expiration date if you wish
- Copy the token and store it somewhere you have easy access to
2. **FIND COURSE ID**
- In canvas, navigate to which class you would like to use with EvenEval through the *courses* button
- Once there, look in your url bar, and at the end of the url, the course id will be displayed
- i.e. in the url bar of this screenshot the url is `https://canvas.ou.edu/courses/244904` the course id would be 244904
3. Enter the id, api key, and canvas link into config dropdown

4. To

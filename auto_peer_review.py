from canvasapi.exceptions import CanvasException

import config
import canvasapi



class APR:
    def create_assn(self, assignment_name, cat_id):
        description = '<p>Directions for this assignment go as follows.<br>' \
                      '<ol><li> Click the "Start Assignment" button </li> <li> Now Type your name in the text box</li>' \
                      '<li> Click Submit.</li> </ol> <br>' \
                      'The easy part is done. In order for you to get credit. You must do these first steps.<br>' \
                      'Now after everyone has submitted begin Part 2: <br> <ol><li>On the right should appear ' \
                      '"Assigned Peer Reviews", click on the first Anonymous User</li>' \
                      '<li>Now should appear a submission with your teammates Name. On the right should be a box' \
                      ' labeled "Add a comment." Type your peer evaluation of the person whose name appears.</li>' \
                      '<li>Click Save. </li> <br> These are the steps for completing the peer evaluation. ' \
                      'Suggestions for peer evaluations include:<br>'\
                      '<br> Positive comments should include words like: <ul> <li>"Great job."</li>' \
                      ' <li> "He is the best at..." </li> <li>"Good communicator." </li></ul> <br>' \
                      '<br>Negative comments should include words like: <ul> <li>"Horrible job."</li>' \
                      ' <li> "He is the worst at..." </li> <li>"Terrible communicator." </li></ul> <br>' \
                      'The analysis takes all caps into consideration so use them for emphasis.' \
                      'If you run into any issues please let me know.'

        assignment = config.COURSE.create_assignment({
            'name': assignment_name,
            'peer_reviews': True,
            'anonymous_peer_reviews': True,
            'submission_types': 'online_text_entry',
            'points_possible': 10,
            'description': description,
            'published' : True
        })
        # users = config.COURSE.get_users(enrollment_type=['student'])
        # for user in users:
        # assignment.get_submission(user).edit(workflow_state='submitted')
        self.generate_peer_reviews(assignment, cat_id)

    def generate_peer_reviews(self, assignment, cat_id):
        groups = config.COURSE.get_groups()
        for group in groups:
            if str(group.group_category_id) == cat_id:
                users = group.get_users()
                for student1 in users:
                    for student2 in users:
                        if (student1.id != student2.id):
                             # assignment.submit({'submission_type':'none', 'user_id':student1.id})
                            try:
                                assignment.get_submission(student1.id).create_submission_peer_review(student2.id)
                            except CanvasException as err:
                                assignment.delete()
                                print('Assignment not created: could not assign peer reviews', err)
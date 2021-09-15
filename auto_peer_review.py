import config
import canvasapi
import Grouper


class APR:
    def create_assn(self, assignment_name, positive_negative):
        positive = '<p>First off, we need everyone to submit a their name in the text. This is just so the peer ' \
                   'review section will pop up. Also, it allows the reviewer to stay anonyomous while also knowing ' \
                   'who they are reviewing. <br> For this assignment test, I want you to ' \
                   'write something really positive in the peer review. ' \
                   '<br> This can include: <ul> <li>"Great work."</li> <li> "He is the BEST."</li> </ul> <br> The ' \
                   'analysis takes all caps into consideration so use them for emphasis. Please write at least ' \
                   'a couple of sentences about how great something is. We are trying to see if the code can ' \
                   'make a good positive analysis and assign the grade accordingly.'
        negative = '<p>First off, we need everyone to submit a their name in the text. This is just so the peer ' \
                   'review section will pop up. Also, it allows the reviewer to stay anonyomous while also knowing ' \
                   'who they are reviewing. <br> For this assignment test, I want you to write something really ' \
                   'negative in the ' \
                   'peer review. ' \
                   '<br> This can include: <ul> <li>"Terrible work."</li> <li> "He is the WORST."</li> </ul> <br> The ' \
                   'analysis takes all caps into consideration so use them for emphasis. Please write at least ' \
                   'a couple of sentences about how bad something is. We are trying to see if the code can ' \
                   'make a good negative analysis and assign the grade accordingly.'
        random = '<p> First off, we need everyone to submit a their name in the text. This is just so the peer ' \
                 'review section will pop up. Also, it allows the reviewer to stay anonyomous while also knowing ' \
                 'who they are reviewing. <br> Now at random choose to do a positive or negative review. Maybe be ' \
                 'more pointed to how you would do it if they are actually your teammate. '
        if (positive_negative == 'P'):
            description = positive
        elif(positive_negative == 'R'):
            description = random
        else:
            description = negative
        assignment = config.COURSE.create_assignment({
            'name': assignment_name,
            'peer_reviews': True,
            'anonymous_peer_reviews': True,
            'submission_types': 'online_text_entry',
            'points_possible': 10,
            'description': description,
        })
        # users = config.COURSE.get_users(enrollment_type=['student'])
        # for user in users:
        # assignment.get_submission(user).edit(workflow_state='submitted')
        self.generate_peer_reviews(assignment)

    def generate_peer_reviews(self, assignment):
        groups = config.COURSE.get_groups()
        for group in groups:
            users = group.get_users()
            for student1 in users:
                for student2 in users:
                    if (student1.id != student2.id):
                        # assignment.submit({'submission_type':'none', 'user_id':student1.id})
                        assignment.get_submission(student1.id).create_submission_peer_review(student2.id)

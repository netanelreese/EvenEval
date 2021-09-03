import config
import canvasapi
import Grouper


class APR :
    def create_assn(self, assignment_name):
        assignment = config.COURSE.create_assignment({
            'name': assignment_name,
            'peer_reviews': True,
            'anonymous_peer_reviews':True,
            'submission_types':'none'
        })
        self.generate_peer_reviews(assignment)

    def edit_reviewer_count(self):
        print()

    def edit_anonymity(self):
        print()

    def assign_APR_to_group(self):
        print()

    def generate_peer_reviews(self, assignment):
        groups = config.COURSE.get_groups()
        for group in groups:
            users = group.get_users()
            for student1 in users:
                for student2 in users:
                    if (student1.id != student2.id):
                        #assignment.submit({'submission_type':'none', 'user_id':student1.id})
                        assignment.get_submission(student1.id).create_submission_peer_review(student2.id)

    def sentiment_analysis(self):
        print()


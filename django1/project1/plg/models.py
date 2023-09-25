from django.db import models

# Create your models here.
class DirectView(models.Model):
    directViewID = models.AutoField(primary_key=True)
    problemStatement = models.CharField(max_length=255)
    abstractData = models.TextField()
    blockDiagram = models.TextField()
    solution = models.TextField()
    implementation = models.TextField()
    conclusion = models.TextField()

    def __str__(self):
        return self.problemStatement

class Project(models.Model):
    projectId = models.AutoField(primary_key=True)
    title = models.CharField(max_length=255)
    directViews = models.ManyToManyField(DirectView)
    def __str__(self):
        return self.title

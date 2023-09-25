from django.shortcuts import render
from django.http import HttpResponse
from django.http import JsonResponse
import json
from plg.models import DirectView
from django.views.decorators.csrf import csrf_exempt
import sys
sys.path.append(r'C:\Users\kusha\Desktop\SmartIndiaHackathon')

from ML_algorithms import bert_plg,turnitin
# Create your views here.
def members(request):
    return HttpResponse("Hello, world. ")

@csrf_exempt
def check_plg(request,pk):
    # print(pk)
    direct_view_solutions = DirectView.objects.exclude(project__projectId=pk).values_list('project__projectId', 'solution')
    # direct_view_solutions = DirectView.objects.exclude(project__projectId=pk).values_list('solution', flat=True)
    direct_view_solution_pk = DirectView.objects.filter(project__projectId=pk).values_list('solution', flat=True)
    # print(direct_view_solutions)
    project_ids = {}
    solutions = []

# Iterate over the QuerySet and separate the values
    for project_id, solution in direct_view_solutions:
        project_ids[solution]=project_id
        solutions.append(solution)
    direct_view_solution_pk_list = list(direct_view_solution_pk)

    # # Create a new list with direct_view_solution_pk as the first element
    new_list = [direct_view_solution_pk_list[0]] + list(solutions)
    r=bert_plg.check(new_list)
    rdict={}
    rdict["project_id"]=project_ids[r[0]['Document']]
    rdict['Similarity']=r[0]['Similarity']
    print(rdict)
    print("-------------------------------------------------------")
    # print(direct_view_solution_pk_list[0])
    rtur=turnitin.turnitin_check(direct_view_solution_pk_list[0],0)
    print(rtur[0])
    # Convert the QuerySet to a list
    # print(direct_view_solutions_list)
    return JsonResponse({'message': 'Resource updated successfully'})
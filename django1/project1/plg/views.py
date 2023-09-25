from django.shortcuts import render
from django.http import HttpResponse
from django.http import JsonResponse
import json
from plg.models import DirectView
from django.views.decorators.csrf import csrf_exempt
# Create your views here.
def members(request):
    return HttpResponse("Hello, world. ")

@csrf_exempt
def check_plg(request,pk):
    print(pk)
    direct_view_solutions = DirectView.objects.exclude(project__projectId=pk).values_list('solution', flat=True)

    # Convert the QuerySet to a list
    direct_view_solutions_list = list(direct_view_solutions)
    print(direct_view_solutions_list)
    return JsonResponse({'message': 'Resource updated successfully'})
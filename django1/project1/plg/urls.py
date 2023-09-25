from django.urls import path
from . import views
urlpatterns = [
    path('', views.members, name='members'),
    path('check_plg/<int:pk>', views.check_plg, name='check_plg')
    
]
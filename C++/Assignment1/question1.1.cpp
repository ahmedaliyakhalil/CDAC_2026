#include<iostream>
using namespace std;

int range(int range )
{
    if(range<0)
    {
        return -1;
    }
    else if(range>=0 && range <=29){
        return 0;
    }else if(range>=30 && range <=44){
        return 1;
    }else if(range>=45 && range <=59){
        return 2;
    }else{
        return 3;
    }
    
}


void statuscode(int statuslabel)
{
    switch(statuslabel){

        case -1:
            cout<< "Status: "<< "SENSOR_ERROR"<<endl;
            cout<<"Action: "<<"Sensor fault - check wiring"<<endl;
            break;
        
        case 0:
            cout<< "Status: "<< "NORMAL"<<endl;
            cout<<"Action: "<<"No action required"<<endl;
            break;
        case 1:
        
            cout<< "Status: "<< "WARNING"<<endl;
            cout<<"Action: "<<"alert sent to supervisor"<<endl;
            break;
        
        case 2:

            cout<< "Status: "<< "CRITICAL"<<endl;
            cout<<"Action: "<<"cooling system triggered"<<endl;
            break;

        default:
            cout<< "Status: "<< "SHUTDOWN"<<endl;
            cout<<"Action: "<<"emergency shutdown initiated "<<endl;
    

    }

        

}




int main(){
    double reading;
    

    cout<<"enter the temperature: "<<endl;
    cin>>reading;
    
   

    double fahrenheit = (reading * 9.0/5.0)+32.0;
    cout<<"temperature : "<<reading <<" C /"<<fahrenheit<<" F"<<endl;

    int statuslabel= range(reading);
    statuscode(statuslabel); 

    (reading>=25)?(cout <<"reading : above average "<<endl): (cout<<"reading : below average"<<endl);
    return 0;
}
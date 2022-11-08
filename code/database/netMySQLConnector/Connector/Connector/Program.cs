using System;

namespace Connector
{
    internal class Program
    {
        static void Main(string[] args)
        {
            
            Connector mydb=new Connector();
            ClassDataType[] list=mydb.searchWithTitle("ICSI201");
            for (int i = 0; i < list.Length; i++)
            {
                Console.WriteLine(list[i].level);
                Console.WriteLine(list[i].department);
                Console.WriteLine(list[i].classNumber);
                Console.WriteLine(list[i].courseInfo);
                Console.WriteLine(list[i].meetingTime);
                Console.WriteLine(list[i].meetingLocation);
                Console.WriteLine(list[i].prerequest);
                Console.WriteLine(list[i].labrequest);
                Console.WriteLine(list[i].creditRange);
                Console.WriteLine(list[i].classType);
                Console.WriteLine(list[i].seatsRemain);
                Console.WriteLine(list[i].session);
                Console.WriteLine(list[i].courseDelivery);
                Console.WriteLine(list[i].genEd);
                Console.WriteLine(list[i].specialRestriction);
                Console.WriteLine(list[i].description);
                Console.WriteLine();
            }
            

        }





    }
}

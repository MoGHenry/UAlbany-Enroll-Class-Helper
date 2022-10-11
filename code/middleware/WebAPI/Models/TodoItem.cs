namespace WebAPI.Models
{
    public class TodoItem 
    {
        public long Id { get; set; }
        public string level { get; set; } //3
        public string department { get; set; } //4
        public int classNumber { get; set; } //5
        public string courseInfo { get; set; } //6
        public string meetingTime { get; set; } //7
        public string meetingLocation { get; set; }
        public string prerequest { get; set; } //8
        public string labrequest { get; set; }
        public string creditRange { get; set; } //9
        public string classType { get; set; } //10
        public int seatsRemain { get; set; } //11
        public string session { get; set; } //12
        public string courseDelivery { get; set; } //13
        public string genEd { get; set; } //14
        public string specialRestriction { get; set; } //15
        public string description { get; set; } //16
        public string other { get; set; } //17 
    }
}

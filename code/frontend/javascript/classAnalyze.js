function analyzeTime(data)
{
    alert("start analyze time");
    let output =  {week: '',time:''};
    let timeJson = data.meetingTime;
    // timeJson = 'TTH 04:30_PM-05:50_PM';
    let time_array = timeJson.split(' ');
    let week = time_array[0];
    let hours = time_array[1];
    let hours_array = hours.split("-");
    console.log("start and end");
    let start_hour = hours_array[0];
    let end_hour = hours_array[1];
    start_hour = start_hour.replace(':','');
    end_hour = end_hour.replace(':','');
    let start_time = start_hour.split('_')[0];
    let end_time = end_hour.split('_')[0];
    if (start_hour.endsWith('PM'))
    {
        start_time = start_time*1 + 1200;
    }
    if (end_hour.endsWith('PM'))
    {
        end_time = end_time*1 + 1200;
    }
    output.time = 'time-'+ start_time + ' / time-' + end_time;

    output.week = [];
    if (week.indexOf('M') !== -1)
    {
        output.week.push('session track-Monday');
        week.replace('M','');
    }
    if (week.indexOf('TH') !== -1)
    {
        output.week.push('session track-Thursday');
        week.replace('TH','');
    }
    if (week.indexOf('W') !== -1)
    {
        output.week.push('session track-Wednesday');
        week.replace('W','');
    }
    if (week.indexOf('T') !== -1)
    {
        output.week.push('session track-Tuesday');
        week.replace('T','');
    }
    if (week.indexOf('F') !== -1)
    {
        output.week.push('session track-Friday');
        week.replace('F','');
    }
    return output;
}

function mergeClassTimes(data)
{
    let output={};
    let output_value = [];
    output.id = data.id;
    output.number = data.number;
    let value = data.value;
    let courseList = JSON.parse(value);
    for(let i=0; i<courseList.length; i++)
    {
        let course = courseList[i];
        if(output_value.some(e => e.courseInfo === course.courseInfo))
        {

        }

    }
}

// function analyzeTime()
// {
//     let output =  '';
//     let gridrow = document.getElementById('test-class-slot').style.gridRow;
//     alert(gridrow);
//     document.getElementById('test-class-slot').style.gridRow = 'time-1030 / time-1315';
//     console.log("got gridRow");
//     alert(document.getElementById('test-class-slot').style.gridRow);
//     return null;
// }
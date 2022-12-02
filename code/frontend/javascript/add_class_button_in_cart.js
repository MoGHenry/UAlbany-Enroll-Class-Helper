function add_class_button_in_cart()
{
    let data = {};
    if('decided_class' in localStorage)
        data = JSON.parse(localStorage.getItem('decided_class'));
    else
        data = JSON.parse(localStorage.getItem('selected_class_with_time'));
    let i=0;
    for (const [key, value] of Object.entries(data))
    {
        document.getElementById('class-list').innerHTML += '' +
            '\n' +
            '    <div>\n' +
            '        <button type="button" class="class-title-button-N">Title</button>\n' +
            '        <div class="time-list-N">\n' +
            '            <!--javascript add code here-->\n' +
            '        </div>\n' +
            '    </div>';
        document.getElementsByClassName('class-title-button-N')[0].style.order = i.toString();
        document.getElementsByClassName('class-title-button-N')[0].innerHTML = value.courseTitle;
        document.getElementsByClassName('class-title-button-N')[0].className = 'class-title-button-'+i;
        addTimeList();
        document.getElementsByClassName('time-list-N')[0].className = 'time-list-'+i;

        i=i+1;
    }
}

function addTimeList()
{
    document.getElementsByClassName('time-list-N')[0].innerHTML = '' +
        '';
}
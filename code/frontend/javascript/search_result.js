console.log("in function");
console.log(json);
for (let i = 0; i < json.length; i++) {
    let title = json[i].courseInfo;
    let course_id = title.replace(/\s/g, '');
    document.getElementById('class-div').innerHTML += '' +
        '    <div class="container px-4 my-4 text-center">\n' +
        '        <div class="row gx-5">\n' +
        '            <div class="col">\n' +
        //TODO modify id to dynamic
        '                <div id="class-1" class="p-2 border btn-primary" onclick="show_description(this.id)">ICSI 418</div>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>' +
        '<div id="class-des"></div>' +
        '';
    document.getElementById('class-1').id = course_id;
    document.getElementById(course_id).innerHTML = title;
    id_description[course_id] = json[i];
}



function init_cart(){
    return document.getElementById('hide-cart-item').value;
}

let classes = init_cart();

for(let i=0; i<classes.length; i++)
{
    let course_id = classes[i].key;
    let title = classes[i];
    document.getElementById('class-list').innerHTML += '' +
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
    document.getElementById(course_id).innerHTML= title;
}


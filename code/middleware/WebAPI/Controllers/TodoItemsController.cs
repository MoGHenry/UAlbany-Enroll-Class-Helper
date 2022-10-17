using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebAPI.Models;
using Newtonsoft.Json;

namespace WebAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TodoItemsController : ControllerBase
    {
        private readonly TodoContext _context;

        public TodoItemsController(TodoContext context)
        {
            _context = context;
        }

        // GET: api/TodoItems
        [HttpGet]
        public async Task<ActionResult<TodoItem>> GetTodoItems()
        {
            ClassDataType classDataType1 = new ClassDataType()
            {
                level = "Undergraduate",
                department = "Africana Studies",
                classNumber = 6882,
                courseInfo = "AAFS 101 Intro to Africana Studies",
                meetingTime = "TTH 04:30_PM-05:50_PM",
                meetingLocation = "Humanities 024 Agum,David",
                prerequest = "",
                labrequest = "",
                creditRange = "3.0- 3.0",
                classType = "",
                seatsRemain = 0,
                session = "FULL",
                courseDelivery = "INPERSON",
                genEd = "CHALLENGES",
                specialRestriction = "None",
                description = "This course will introduce students to the historical foundations of Africana Studies and discuss its relevance to contemporary society. An interdisciplinary approach will be incorporated as History, Philosophy, Literature, Performing Arts, Sociology, Psychology, Religion/Spirituality, and Anthropology are employed to provide students a detailed analysis of people of African descent in the Western Hemisphere. ",
                other = ""
            };
            ClassDataType classDataType2 = new ClassDataType()
            {
                level = "Undergraduate",
                department = "Africana Studies",
                classNumber = 9752,
                courseInfo = "AAFS 150 Life In The Third World",
                meetingTime = "12:00_AM-12:00_AM",
                meetingLocation = "Online Agum,David",
                prerequest = "",
                labrequest = "",
                creditRange = "3.0- 3.0",
                classType = "",
                seatsRemain = 0,
                session = "8W2",
                courseDelivery = "ONLASYNCH/ONLFULL",
                genEd = "INTLPER",
                specialRestriction = "None",
                description = "Introduction to cultural variation and fragmentation among third-world developing communities. Some lectures and discussions are led by third-world graduate students. Whenever possible, distinguished visitors from third-world countries are also involved in the course.",
                other = ""
            };
            ClassDataType[] classDataTypes = new ClassDataType[2];
            classDataTypes[0] = classDataType1;
            classDataTypes[1] = classDataType2;
            TodoItem todoItem = new TodoItem() {
                Id=0,
                number = 2,
                value = JsonConvert.SerializeObject(classDataTypes)
            };
            return todoItem;
        }

        // GET: api/TodoItems/5
        [HttpGet("{id}")]
        public async Task<ActionResult<TodoItem>> GetTodoItem(long id)
        {
            var todoItem = await _context.TodoItems.FindAsync(id);

            if (todoItem == null)
            {
                return NotFound();
            }

            return todoItem;
        }

        // PUT: api/TodoItems/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutTodoItem(long id, TodoItem todoItem)
        {
            if (id != todoItem.Id)
            {
                return BadRequest();
            }

            _context.Entry(todoItem).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TodoItemExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/TodoItems
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<TodoItem>> PostTodoItem(TodoItem todoItem)
        {
            _context.TodoItems.Add(todoItem);
            await _context.SaveChangesAsync();

            //return CreatedAtAction("GetTodoItem", new { id = todoItem.Id }, todoItem);
            return CreatedAtAction(nameof(GetTodoItem), new { id = todoItem.Id }, todoItem);
        }

        // DELETE: api/TodoItems/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteTodoItem(long id)
        {
            var todoItem = await _context.TodoItems.FindAsync(id);
            if (todoItem == null)
            {
                return NotFound();
            }

            _context.TodoItems.Remove(todoItem);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool TodoItemExists(long id)
        {
            return _context.TodoItems.Any(e => e.Id == id);
        }
    }
}

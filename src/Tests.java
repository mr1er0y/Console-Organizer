public static void assertEquals(Object expected, Object actual)

public class TaskTest {

  @Test
    public void TestAdd  {
      public  ArrayList<Task> task_list;
      task_list.add(new Task('save'))
      assert(task_list[0] == new Task('save'))
      assert(task_list.size() == 1)
    }

    @Test
    public void TestSave  {
      path = '/Users/masha/Documents/Console-Organizer/src/' + 'masha_super.txt'
      Tasks Task = new Tasks(0);
      Task.add('masha_super.txt')
      File f = new File(path);
      assert(f.exists() && !f.isDirectory())
    }
  
  
}
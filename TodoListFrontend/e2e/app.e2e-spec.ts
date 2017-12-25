import { TodoListNg2Page } from './app.po';

describe('todo-list-ng2 App', function() {
  let page: TodoListNg2Page;

  beforeEach(() => {
    page = new TodoListNg2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});


import './App.css';
//import Header from './components/Header';
//import Body from './components/Body';
//import Todo from './components/Todo';
import TodoList from './components/TodoList';
function App() {
  return (
    <div className="App">
    <h1 className="app-title">ToDo App</h1>
      <TodoList/>
    </div>
  );
}

export default App;

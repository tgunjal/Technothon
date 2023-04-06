import { Route } from 'react-router-dom';

function NewPage() {
  return (
    <div>
      <h1>New Page</h1>
      <p>This is a new page!</p>
    </div>
  );
}

function App() {
  return (
    <div>
      <Route path="/login" component={NewPage} />
    </div>
  );
}

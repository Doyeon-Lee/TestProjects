import React, {Component} from 'react';
//import logo from './logo.svg';
import './App.css';
import TOC from "./components/TOC";
import ReadContent from "./components/ReadContent";
import CreateContent from "./components/CreateContent";
import UpdateContent from "./components/UpdateContent";
import Subject from "./components/Subject";
import Control from "./components/Control";

class App extends Component {
  constructor(props){
    super(props);
    this.max_content_id = 3;
    this.state = {
      mode: "welcome",
      selected_content_id: 2,
      welcome: {title: "Welcome", desc: "Hello, React!"},
      subject:{title: "WEB", sub: "World Wide Web!"},
      contents:[
        {id: 1, title: "HTML", desc: "HTML is for information."},
        {id: 2, title: "CSS", desc: "CSS is for design."},
        {id: 3, title: "JavaScript", desc: "JS is for interactive."}
      ]
    }
  }

  getReadContent(){
    var i = 0;
    while(i < this.state.contents.length){
      var data = this.state.contents[i];

      if(data.id === this.state.selected_content_id)
        return data;
      i++;
    }
  }

  getContent(){
    var _title, _desc, _article = null;

    switch(this.state.mode){
      case 'welcome':
        _title = this.state.welcome.title;
        _desc = this.state.welcome.desc;
        _article = <ReadContent title={_title} desc={_desc}></ReadContent>
        break;

      case 'read':
        var _content = this.getReadContent();
        _article = <ReadContent title={_content.title} desc={_content.desc}></ReadContent>
        break;

      case 'create':
        _article = <CreateContent onSubmit={function(_title, _desc){
          //add content state
          this.max_content_id++;
          var _content = this.state.contents.concat({
            id: this.max_content_id, title: _title, desc: _desc
          });
          this.setState({
            contents: _content,
            mode: 'read',
            selected_content_id: this.max_content_id
          });
        }.bind(this)}></CreateContent>
        break;
        
      case 'update': 
        var data = this.getReadContent();
        _article = <UpdateContent data={data} 
        onSubmit={function(_id, _title, _desc){
          var _contents = Array.from(this.state.contents);

          var i = 0;
          while(i < _contents.length){
            if(_contents[i].id === _id){
              _contents[i] = {id:_id, title: _title, desc: _desc};
              break;
            }
            i++;
          }

          this.setState({
            contents: _contents,
            mode: 'read'
          });
        }.bind(this)}></UpdateContent>
      break;
    }
    return _article;
  }

  render(){
    return (
      <div className="App">
        <Subject title={this.state.subject.title}
        sub={this.state.subject.sub}
        onChangePage={function(){
          this.setState({mode:'welcome'});
        }.bind(this)}
        >
        </Subject>

        <TOC 
          onChangePage = {function(id){
            this.setState({
              mode:'read',
              selected_content_id: Number(id)});
          }.bind(this)}
          data={this.state.contents}
         ></TOC>

        <Control onChangeMode={function(_mode){
          if(_mode === "delete"){
            if(window.confirm('Really?')){
              var _contents = Array.from(this.state.contents);
              
              var i = 0;
              while(i < _contents.length){
                if(this.state.selected_content_id === _contents[i].id){
                  _contents.splice(i,1);
                  break;
                }
                i++;
              }
            }

            this.max_content_id--;
            this.setState({
              mode: 'welcome',
              contents: _contents,
              selected_content_id: this.max_content_id
            })
            alert("Delete completed!");
          }
          else{
            this.setState({mode: _mode})
          }
        }.bind(this)}></Control>

        {this.getContent()}
      </div>
    );
  }
}

export default App;

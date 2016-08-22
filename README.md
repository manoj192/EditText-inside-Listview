# EditText-inside-Listview


 Views are recycled when using an Adapter to solve that use this code
  viewholder.caption.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            final int position = v.getId();
                            final EditText Caption = (EditText) v;
                            myItems.get(position).caption = Caption.getText().toString();
                        }
                    }
                });

Builder := Object clone
Builder indentLevel := 0

Builder writeWithIndent := method(text,
write("   " repeated(indentLevel))
writeln(text)
)

Builder forward := method(
   writeWithIndent("<" .. call message name .. ">")
   indentLevel = indentLevel + 1

   call message arguments foreach(
      arg,
      content := self doMessage(arg);
      if(content type == "Sequence",
         indent(indentLevel)
         writeln(content)
      )
   )
   indentLevel = indentLevel - 1
   writeWithIndent("</" .. call message name .. ">")
)

Builder  ul(
	li("Io"),
	li("Lua"),
	li("JavaScript"))

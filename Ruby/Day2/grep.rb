def find_phrase(filename, phrase)
  if File.file?(filename)
    file = File.open(filename, 'r')
    lines = file.readlines()

    lines.each { |line| puts line if line.include?(phrase) }
  end
end

find_phrase('text.txt', 'It')

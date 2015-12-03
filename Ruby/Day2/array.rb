numbers = (0..15)

puts 'Using .each:'
number_count = 0

numbers.each do |num|
  if(number_count == 0) then
    print '['
  end

  print "#{num}"

  if(number_count >= 3) then
    print "] \n"
    number_count = 0
  else
    print ', '
    number_count = number_count + 1
  end

end

puts ''
puts 'Using .each_slice:'
numbers.each_slice(4) do |num|
   p num
end
